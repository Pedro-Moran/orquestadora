package com.bbva.kbtq.lib.r518.impl;

import com.bbva.elara.domain.transaction.Advice;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.dto.c400.coexistence.CoexistenceInformation;
import com.bbva.kbtq.dto.persons.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Optional;


public class KBTQR518CoexistenceImpl extends KBTQR518Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR518CoexistenceImpl.class);
    private static final String PROPERTY_FUNCTIONAL_NAME = "kbtq.lib.kbtqr518.coexistence.functionalName";
    private static final String PROPERTY_CHECK_TIMESTAMP = "kbtq.lib.kbtqr518.coexistence.timestamp.active";

    public KBTQR518CoexistenceImpl(KBTQR518Abstract clone){
        this.setApplicationConfigurationService(clone.applicationConfigurationService);
        this.setKbtqR110(clone.kbtqR110);
        this.setKbtqR115(clone.kbtqR115);
        this.setKbtqR404(clone.kbtqR404);
        this.setKbtqR718(clone.kbtqR718);
        this.setKbtqR807(clone.kbtqR807);
        this.setKbtqR410(clone.kbtqR410);
    }

    @Override
    public Customer executeGetCustomer(String id) {
        if (id != null && !id.isEmpty()) {
            // get from console APX property to get if is necesary use coexistence or distributed
            // if property is active it will use coexistence
            Optional<String> functionalName = this.kbtqR404.executeGetProperty(PROPERTY_FUNCTIONAL_NAME);
            if (functionalName.isPresent()) {
                Optional<CoexistenceInformation> coexistenceInformation = this.kbtqR404.executeGetFunctionalObject(functionalName.get());
                if (coexistenceInformation.isPresent()
                        && Boolean.TRUE.equals(!coexistenceInformation.get().getMasterIndType())) {
                    return this.executeGetCustomerBasicDataFromCoexistence(id, coexistenceInformation.get().getCutOffDate());
                }
            }
            // if property is not active or is not defined it will use distributed
            return this.executeGetCustomerBasicDataFromDistributed(id);
        }

        this.addAdvice(KbtqAdvices.KBTQ01429000.getId());
        return null;
    }


    public Customer executeGetCustomerBasicDataFromCoexistence(String customerId, Date timeStampFromDist) {
        // ¿la validacion de timestamp esta activa?
        if (this.kbtqR404.executeCheckPropertyIsActive(PROPERTY_CHECK_TIMESTAMP)) {
            LOGGER.info("timestamps: active, now start get timestamps from host and dist");
            //obtener lista de timestamps desde host
            Date timeStampFromCoexistence = this.kbtqR718.executeGetLastUpdateDate(customerId);
            LOGGER.info("timestamps host: {}", timeStampFromCoexistence);
            //ultima fecha de carga desde distribuido
            LOGGER.info("timestamps dist: {}", timeStampFromDist);

            if (this.checkIfAnyErrorObtainingTimestamp()) {
                return null;
            }

            //tengo que ir a host? -> si la fecha de host es mas nueva que la fecha de distribuido
            if (timeStampFromCoexistence == null ||
                    this.kbtqR404.executeCompareDatesFromCoexistenceAndDistributed(timeStampFromCoexistence, timeStampFromDist)) {
                LOGGER.info("get data from host");
                return obtainingFromCoexistenceOrGetFromDistribuitedWithAdvice(customerId);
            } else {
                return obtainingFromDistributedOrGetFromHost(customerId);
            }
        } else {
            LOGGER.info("validate timestamps: not active");
            LOGGER.info("get data from host");
            //No hay validacion de timestamps se devuelve el dato desde host
            return obtainingFromCoexistenceOrGetFromDistribuitedWithAdvice(customerId);
        }
    }

    private Customer obtainingFromCoexistenceOrGetFromDistribuitedWithAdvice(String customerId) {
        Customer customer = kbtqR718.executeGetCustomerBasicData(customerId);

        if (getAdviceList().stream().anyMatch(q -> KbtqAdvices.KBTQ01429036.getId().equalsIgnoreCase(q.getCode()))) {
            return null;
        }

        if (customer == null) {
            customer = this.executeGetCustomerBasicDataFromDistributed(customerId);
            if (customer != null) {
                this.getAdviceList().removeIf(advice -> KbtqAdvices.KBTQ01429104.getId().equals(advice.getCode()));
                Advice advice = new Advice();
                advice.setCode(KbtqAdvices.KBTQ01429105.getId());
                this.getAdviceList().add(advice);
            }
        }
        return customer;
    }

    private boolean checkIfAnyErrorObtainingTimestamp() {
        //recurso no existe
        if (this.getAdviceList().stream().anyMatch(q -> KbtqAdvices.KBTQ01429036.getId().equalsIgnoreCase(q.getCode()))) {
            return true;
        }
        //no se ha podido acceder al recurso -> limpiamos el advice, y contina el flujo
        if (this.getAdviceList().stream().anyMatch(q -> KbtqAdvices.KBTQ01429104.getId().equalsIgnoreCase(q.getCode()))) {
            this.getAdviceList().removeIf(q -> KbtqAdvices.KBTQ01429104.getId().equalsIgnoreCase(q.getCode()));
            return false;
        }
        return false;
    }

    public Customer executeGetCustomerBasicDataFromDistributed(String customerId) {
        return new KBTQR518DistributedImpl(this).executeGetCustomer(customerId);
    }

    private Customer obtainingFromDistributedOrGetFromHost(String customerId) {
        Customer resource = this.executeGetCustomerBasicDataFromDistributed(customerId);
        if (resource == null) {
            resource = kbtqR718.executeGetCustomerBasicData(customerId);
            if (resource != null){
                this.getAdviceList().removeIf(advice -> advice.getCode().equalsIgnoreCase(KbtqAdvices.KBTQ01429036.getId()));
            }
        }
        return resource;
    }
}