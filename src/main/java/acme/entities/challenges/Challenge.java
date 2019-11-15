
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goalGOLD;

	@NotBlank
	private String				goalSILVER;

	@NotBlank
	private String				goalBRONZE;

	@Valid
	@NotNull
	private Money				rewardGOLD;

	@Valid
	@NotNull
	private Money				rewardSILVER;

	@Valid
	@NotNull
	private Money				rewardBRONZE;

}
