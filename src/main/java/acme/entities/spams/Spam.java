
package acme.entities.spams;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spam;

	private double				threshold;


	public String threshold() {
		StringBuilder res = new StringBuilder();
		res.append(this.threshold);
		res.append("%");
		return res.toString();
	}

}
