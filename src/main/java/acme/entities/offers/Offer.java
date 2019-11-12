
package acme.entities.offers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				text;

	@Valid
	@NotNull
	private Money				maxMoney;

	@Valid
	@NotNull
	private Money				minMoney;

	@Pattern(regexp = "[O][A-Z]{4}-[0-9]{5}")
	@NotBlank
	@Column(unique = true)
	private String				ticker;


	@Transient
	public String rangeMoney() {
		StringBuilder res = new StringBuilder();
		res.append(this.maxMoney);
		res.append(" - ");
		res.append(this.minMoney);
		return res.toString();
	}

}
