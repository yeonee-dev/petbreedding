package kh.com.petbreedding.cta.model.vo;

public class Cta {
private String CM_CODE;
private String CM_TYPE;
private int PRICE;


public String getCM_CODE() {
	return CM_CODE;
}
public void setCM_CODE(String cM_CODE) {
	CM_CODE = cM_CODE;
}
public String getCM_TYPE() {
	return CM_TYPE;
}
public void setCM_TYPE(String cM_TYPE) {
	CM_TYPE = cM_TYPE;
}
public int getPRICE() {
	return PRICE;
}
public void setPRICE(int pRICE) {
	PRICE = pRICE;
}
@Override
public String toString() {
	return "Cta [CM_CODE=" + CM_CODE + ", CM_TYPE=" + CM_TYPE + ", PRICE=" + PRICE + "]";
}




}
