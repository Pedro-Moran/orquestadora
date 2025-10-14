package com.bbva.pfmh.lib.r015.impl;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import com.bbva.elara.utility.interbackend.cics.InterBackendCicsUtils;
import com.bbva.elara.utility.interbackend.cics.dto.HostAdvice;
import com.bbva.elara.utility.interbackend.cics.dto.HostAttributeResponse;
import com.bbva.elara.utility.interbackend.cics.dto.SendMessageResponse;
import com.bbva.elara.utility.interbackend.cics.dto.Status;
import com.bbva.pfmh.dto.fmc7.constant.PFMHC005Constant;
import com.bbva.pfmh.dto.fmc7.pague.FFMMPagination;
import com.bbva.pfmh.dto.fmc7.request.FMC7Request;
import com.bbva.pfmh.dto.fmc7.response.FMC7Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class PFMHR015ImplTest {
	@InjectMocks
	private PFMHR015Impl pfmhR015;

	@Mock
	private InterBackendCicsUtils interBackendCicsUtils;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ThreadContext.set(new Context());
	}

	private SendMessageResponse genereteMockCicsResponse(List<String> formats, List<String> values, List<HostAdvice> hostAdvices, Status status) {
		SendMessageResponse sendMessageResponse;
		SendMessageResponse.Builder builderMessageResponse = SendMessageResponse.newBuilder().setStatus(status);
		for (int i = 0; i < values.size(); i++) {
			HostAttributeResponse.Builder builderAttributeResponse = HostAttributeResponse.newBuilder();
			builderAttributeResponse.setFormat(formats.get(i));
			builderAttributeResponse.setValue(values.get(i));
			builderMessageResponse.addAttributeResponse(builderAttributeResponse.build());
		}
		builderMessageResponse.addAllHostAdvices(hostAdvices);
		sendMessageResponse = builderMessageResponse.build();
		return sendMessageResponse;
	}

	private FMC7Request getFMC7Request() {
		FMC7Request request = new FMC7Request();
		request.setNumCli("00001171");
		request.setIndPagi("");
		request.setTamPagi(025);
		return request;
	}

	@Test
	public void executeTestOK() {
		List<String> formats = new ArrayList<>();
		List<String> values = new ArrayList<>();
		formats.add(PFMHC005Constant.HostProperties.FFMM7_FORMAT);
		String ffmm7Value = "00110122998000000412"
				+ "0000023468104377G"
				+ "0000000005431673G"
				+ "PEN"
				+ "0031"
				+ String.format("%-50s", "BBVA CASH SOLES")
				+ String.format("%-35s", "SOLES")
				+ "0000000005431673G"
				+ "0000002314491918G"
				+ "L"
				+ String.format("%-30s", "CODIGO INTERNO DEL BBVA");
		values.add(ffmm7Value);
		formats.add(PFMHC005Constant.HostProperties.FMMAC72);
		values.add("123456789012345678XYZ003");
		List<HostAdvice> advicesList = new ArrayList<>();
		SendMessageResponse sendMessageResponse = genereteMockCicsResponse(formats, values, advicesList, Status.OK);
		Mockito.when(interBackendCicsUtils.invokeCics(Mockito.anyString(), Mockito.anyString(), Mockito.anyMap())).thenReturn(sendMessageResponse);
		FMC7Response response = pfmhR015.executeFMC7(getFMC7Request());
		Assert.assertNotNull(response);
		Assert.assertEquals(0, pfmhR015.getAdviceList().size());
		Assert.assertEquals("00110122998000000412", response.getFfmm7().get(0).getIdContr());
                Assert.assertEquals(new BigDecimal("2346.81043777"), response.getFfmm7().get(0).getNumCuot());
                Assert.assertEquals(new BigDecimal("543167.37"), response.getFfmm7().get(0).getSalDisp());
		Assert.assertEquals("PEN", response.getFfmm7().get(0).getdMonEsd());
		Assert.assertEquals("0031", response.getFfmm7().get(0).getIdSubPr());
		Assert.assertEquals("BBVA CASH SOLES", response.getFfmm7().get(0).getdSubPro().trim());
		Assert.assertEquals("SOLES", response.getFfmm7().get(0).getIdMonFn().trim());
                Assert.assertEquals(new BigDecimal("543167.37"), response.getFfmm7().get(0).getSalCont());
                Assert.assertEquals(new BigDecimal("231.44919187"), response.getFfmm7().get(0).getValCuot());
		Assert.assertEquals("L", response.getFfmm7().get(0).getcTipNum());
		Assert.assertEquals("CODIGO INTERNO DEL BBVA", response.getFfmm7().get(0).getdTipNum().trim());
		Assert.assertEquals("123456789012345678", response.getPagination().getIdpagin());
		Assert.assertEquals(Integer.valueOf(3), response.getPagination().getTampagi());
	}

	@Test
	public void executeTestFatal() {
		List<String> formats = new ArrayList<>();
		List<String> values = new ArrayList<>();
		HostAdvice hostAdvice = new HostAdvice();
		List<HostAdvice> adviceList = new ArrayList<>();
		adviceList.add(hostAdvice);
		SendMessageResponse sendMessageResponse = genereteMockCicsResponse(formats, values, adviceList, Status.FATAL);
		Mockito.when(interBackendCicsUtils.invokeCics(Mockito.anyString(), Mockito.anyString(), Mockito.anyMap())).thenReturn(sendMessageResponse);
		FMC7Response response = pfmhR015.executeFMC7(getFMC7Request());
		Assert.assertNotNull(response);
	}

	@Test
	public void executeTestBusinessException() {
		Mockito.when(interBackendCicsUtils.invokeCics(Mockito.anyString(), Mockito.anyString(), Mockito.anyMap()))
				.thenThrow(new BusinessException("01", true, "Host Transaction Failed;[HostAdvice{code='FMC7', description='NO EXISTEN DATOS A MOSTRAR.                   '}];06 at com.bbva.elara.utility.interbackend.cics.ps10.deformatter.DeformatterCics.validateStatus(DeformatterCics.java:107)", new Throwable()));
		FMC7Response response = pfmhR015.executeFMC7(getFMC7Request());
		Assert.assertNotNull(response);
		Assert.assertEquals("FMC7", response.getHostAdviceCode());
		Assert.assertEquals("NO EXISTEN DATOS A MOSTRAR", response.getHostMessage().trim().replaceAll("\\.$", ""));
	}

	@Test
	public void executeTestShortValue() {
		List<String> formats = new ArrayList<>();
		List<String> values = new ArrayList<>();
		formats.add(PFMHC005Constant.HostProperties.FFMM7_FORMAT);
		values.add("123");
		SendMessageResponse sendMessageResponse = genereteMockCicsResponse(formats, values, new ArrayList<>(), Status.OK);
		Mockito.when(interBackendCicsUtils.invokeCics(Mockito.anyString(), Mockito.anyString(), Mockito.anyMap())).thenReturn(sendMessageResponse);
		FMC7Response response = pfmhR015.executeFMC7(getFMC7Request());
		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getFfmm7().size());
		Assert.assertEquals("123", response.getFfmm7().get(0).getIdContr());
                Assert.assertEquals(new BigDecimal("0E-8"), response.getFfmm7().get(0).getNumCuot());
		Assert.assertEquals("", response.getFfmm7().get(0).getdMonEsd());
	}

	@Test
	public void mapPaginationFFMM() {
		FFMMPagination input = new FFMMPagination();
		input.setIdpagin("123");
		input.setTampagi(10);
		FFMMPagination result = pfmhR015.mapPaginationFFMM(input);
		Assert.assertNotNull(result);
		Assert.assertEquals("123", result.getIdpagin());
		Assert.assertEquals(Integer.valueOf(10), result.getTampagi());
	}

	@Test
	public void testmapPaginationFFMMWithNullInput() {
		FFMMPagination result = pfmhR015.mapPaginationFFMM(null);
		Assert.assertNull(result);
	}

	@Test
	public void testExtractStringAndBigDecimal() throws Exception {
		Method extractString = PFMHR015Impl.class.getDeclaredMethod("extractString", String.class, int.class, int.class);
		extractString.setAccessible(true);
		String result = (String) extractString.invoke(pfmhR015, "ABCDEF", 1, 3);
		Assert.assertEquals("BCD", result);
		String outOfBounds = (String) extractString.invoke(pfmhR015, "ABC", 5, 2);
		Assert.assertEquals("", outOfBounds);

		Method extractBigDecimal = PFMHR015Impl.class.getDeclaredMethod("extractBigDecimal", String.class, int.class, int.class, int.class);
		extractBigDecimal.setAccessible(true);
		BigDecimal number = (BigDecimal) extractBigDecimal.invoke(pfmhR015, "0000012345", 0, 10, 2);
		Assert.assertEquals(new BigDecimal("123.45"), number);
                BigDecimal zero = (BigDecimal) extractBigDecimal.invoke(pfmhR015, "          ", 0, 10, 2);
                Assert.assertEquals(new BigDecimal("0.00"), zero);
	}

	@Test
	public void testCleanAndSafeSubstring() throws Exception {
                Method clean = PFMHR015Impl.class.getDeclaredMethod("cleanAndConvertToBigDecimal", String.class);
                clean.setAccessible(true);
                BigDecimal cleaned = (BigDecimal) clean.invoke(pfmhR015, "a1b2c3");
                Assert.assertEquals(new BigDecimal("123"), cleaned);
                Assert.assertEquals(BigDecimal.ZERO, (BigDecimal) clean.invoke(pfmhR015, "abc"));
                Assert.assertEquals(BigDecimal.ZERO, (BigDecimal) clean.invoke(pfmhR015, (Object) null));
                Assert.assertEquals(new BigDecimal("2830840671"), (BigDecimal) clean.invoke(pfmhR015, "0000000283084067A"));
                Assert.assertEquals(new BigDecimal("-2830840671"), (BigDecimal) clean.invoke(pfmhR015, "0000000283084067J"));

                Method safe = PFMHR015Impl.class.getDeclaredMethod("safeSubstring", String.class, int.class, int.class);
                safe.setAccessible(true);
                String sub = (String) safe.invoke(pfmhR015, "hello", 1, 10);
                Assert.assertEquals("ello", sub);
		String negative = (String) safe.invoke(pfmhR015, "test", -1, 2);
		Assert.assertEquals("", negative);
		String outRange = (String) safe.invoke(pfmhR015, "hi", 3, 5);
		Assert.assertEquals("", outRange);
	}
}