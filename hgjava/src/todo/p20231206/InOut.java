package todo.p20231206;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InOut {
	private String iocode;
	private LocalDate iodate;
	private int iosum;
	private String io;
	private int pdsum;

	InOut(String iocode, LocalDate iodate, int iosum, int io) {
		this.iocode = iocode;
		this.iodate = iodate;
		this.iosum = iosum;
		if (io == 1) {
			this.io = "구매";

		} else if (io == 2) {
			this.io = "판매";
		}
	}

	InOut(String iocode, int pdsum) {
		this.iocode = iocode;
		this.pdsum = pdsum;
	}
}
