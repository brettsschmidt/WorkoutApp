
public class Workout 
{
	private long m_WKOUT_ID;
	private String m_WKOUT_NAME;
	private String m_WKOUT_VIDEO;
	private String m_WKOUT_DESC;
	private String m_WKOUT_CAT;
	private long m_WKOUT_ADD_USER_ID;
	private java.sql.Timestamp m_WKOUT_ADD_DTM;
	private long m_WKOUT_CHG_USER_ID;
	private java.sql.Timestamp m_WKOUT_CHG_DTM;
	private char m_WKOUT_STAT_CD;
	
	public Workout ()
	{
		m_WKOUT_ID = 0;
		m_WKOUT_NAME = null;
		m_WKOUT_VIDEO = null;
		m_WKOUT_DESC = null;
		m_WKOUT_CAT = null;
		m_WKOUT_ADD_USER_ID = 0;
		m_WKOUT_ADD_DTM = null;
		m_WKOUT_CHG_USER_ID = 0;
		m_WKOUT_CHG_DTM = null;
		m_WKOUT_STAT_CD = '\0';
	}

	public long getWKOUT_ID() {
		return m_WKOUT_ID;
	}

	public void setWKOUT_ID(long m_WKOUT_ID) {
		this.m_WKOUT_ID = m_WKOUT_ID;
	}

	public String getWKOUT_NAME() {
		return m_WKOUT_NAME;
	}

	public void setWKOUT_NAME(String m_WKOUT_NAME) {
		this.m_WKOUT_NAME = m_WKOUT_NAME;
	}

	public String getWKOUT_VIDEO() {
		return m_WKOUT_VIDEO;
	}

	public void setWKOUT_VIDEO(String m_WKOUT_VIDEO) {
		this.m_WKOUT_VIDEO = m_WKOUT_VIDEO;
	}

	public String getWKOUT_DESC() {
		return m_WKOUT_DESC;
	}

	public void setWKOUT_DESC(String m_WKOUT_DESC) {
		this.m_WKOUT_DESC = m_WKOUT_DESC;
	}

	public String getWKOUT_CAT() {
		return m_WKOUT_CAT;
	}

	public void setWKOUT_CAT(String m_WKOUT_CAT) {
		this.m_WKOUT_CAT = m_WKOUT_CAT;
	}

	public long getWKOUT_ADD_USER_ID() {
		return m_WKOUT_ADD_USER_ID;
	}

	public void setWKOUT_ADD_USER_ID(long m_WKOUT_ADD_USER_ID) {
		this.m_WKOUT_ADD_USER_ID = m_WKOUT_ADD_USER_ID;
	}

	public java.sql.Timestamp getWKOUT_ADD_DTM() {
		return m_WKOUT_ADD_DTM;
	}

	public void setWKOUT_ADD_DTM(java.sql.Timestamp m_WKOUT_ADD_DTM) {
		this.m_WKOUT_ADD_DTM = m_WKOUT_ADD_DTM;
	}

	public long getWKOUT_CHG_USER_ID() {
		return m_WKOUT_CHG_USER_ID;
	}

	public void setWKOUT_CHG_USER_ID(long m_WKOUT_CHG_USER_ID) {
		this.m_WKOUT_CHG_USER_ID = m_WKOUT_CHG_USER_ID;
	}

	public java.sql.Timestamp getWKOUT_CHG_DTM() {
		return m_WKOUT_CHG_DTM;
	}

	public void setWKOUT_CHG_DTM(java.sql.Timestamp m_WKOUT_CHG_DTM) {
		this.m_WKOUT_CHG_DTM = m_WKOUT_CHG_DTM;
	}

	public char getWKOUT_STAT_CD() {
		return m_WKOUT_STAT_CD;
	}

	public void setWKOUT_STAT_CD(char m_WKOUT_STAT_CD) {
		this.m_WKOUT_STAT_CD = m_WKOUT_STAT_CD;
	}
	
}
