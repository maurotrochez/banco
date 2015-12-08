package co.edu.uniajc.model;

// Generated 10/03/2015 11:21:36 PM by Hibernate Tools 4.0.0

/**
 * ConsignacionesId generated by hbm2java
 */
public class ConsignacionesId implements java.io.Serializable {

	private long conCodigo;
	private String cueNumero;

	public ConsignacionesId() {
	}

	public ConsignacionesId(long conCodigo, String cueNumero) {
		this.conCodigo = conCodigo;
		this.cueNumero = cueNumero;
	}

	public long getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(long conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getCueNumero() {
		return this.cueNumero;
	}

	public void setCueNumero(String cueNumero) {
		this.cueNumero = cueNumero;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConsignacionesId))
			return false;
		ConsignacionesId castOther = (ConsignacionesId) other;

		return (this.getConCodigo() == castOther.getConCodigo())
				&& ((this.getCueNumero() == castOther.getCueNumero()) || (this
						.getCueNumero() != null
						&& castOther.getCueNumero() != null && this
						.getCueNumero().equals(castOther.getCueNumero())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getConCodigo();
		result = 37 * result
				+ (getCueNumero() == null ? 0 : this.getCueNumero().hashCode());
		return result;
	}

}
