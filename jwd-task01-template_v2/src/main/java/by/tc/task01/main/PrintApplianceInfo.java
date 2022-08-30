package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	public static void print(List<Appliance> appliance) {

		for (Appliance ap : appliance) {
			System.out.println(ap);

		}
		System.out.println();

	}

}
