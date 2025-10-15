package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UserMgmtOperationEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserMgmtOperationType;
	private String gUserMgmtOperationName;

	public String getgUserMgmtOperationType() {
		return gUserMgmtOperationType;
	}

	public void setgUserMgmtOperationType(String gUserMgmtOperationType) {
		this.gUserMgmtOperationType = gUserMgmtOperationType;
	}

	public String getgUserMgmtOperationName() {
		return gUserMgmtOperationName;
	}

	public void setgUserMgmtOperationName(String gUserMgmtOperationName) {
		this.gUserMgmtOperationName = gUserMgmtOperationName;
	}

	@Override
	public String toString() {
		return "UserMgmtOperationEntity [gUserMgmtOperationType=" + gUserMgmtOperationType + ", gUserMgmtOperationName=" + gUserMgmtOperationName
				+ ", toString()=" + super.toString() + "]";
	}

}
