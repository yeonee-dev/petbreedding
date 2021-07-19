package kh.com.petbreedding.cta.model.vo;

public class CtaPay {
	private String CHRG_NUM;
	private String CM_CODE;
	private String CM_TYPE;
	private String BP_ID;
	private String CHRG_DATE;
	private int CTA_NUMBER;
	
	
	public String getCHRG_NUM() {
		return CHRG_NUM;
	}
	public String getCM_CODE() {
		return CM_CODE;
	}
	public void setCM_CODE(String cM_CODE) {
		CM_CODE = cM_CODE;
	}
	public String getBP_ID() {
		return BP_ID;
	}
	public void setBP_ID(String bP_ID) {
		BP_ID = bP_ID;
	}
	public String getCHRG_DATE() {
		return CHRG_DATE;
	}
	public void setCHRG_DATE(String cHRG_DATE) {
		CHRG_DATE = cHRG_DATE;
	}
	public void setCHRG_NUM(String cHRG_NUM) {
		CHRG_NUM = cHRG_NUM;
	}
	public int getCTA_NUMBER() {
		return CTA_NUMBER;
	}
	public void setCTA_NUMBER(int cTA_NUMBER) {
		CTA_NUMBER = cTA_NUMBER;
	}
	public String getCM_TYPE() {
		return CM_TYPE;
	}
	public void setCM_TYPE(String cM_TYPE) {
		CM_TYPE = cM_TYPE;
	}
	@Override
	public String toString() {
		return "CtaPay [CHRG_NUM=" + CHRG_NUM + ", CM_CODE=" + CM_CODE + ", CM_TYPE=" + CM_TYPE + ", BP_ID=" + BP_ID
				+ ", CHRG_DATE=" + CHRG_DATE + ", CTA_NUMBER=" + CTA_NUMBER + "]";
	}

	
}
