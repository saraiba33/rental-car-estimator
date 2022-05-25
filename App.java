import java.util.Scanner;

class App {
  public static void main(String args[]) {
    Scanner carRental = new Scanner(System.in);

    System.out.println(
        "Pickup Date, Would you like Toll tag for $3.95/day?, Would you like a gps for $2.95/day?, Would you like roadside assistance for $3.95/day?, Customers Age, Number of days for rental:");

    String pickUpDate = carRental.nextLine();
    String tollTag = carRental.nextLine();
    String gpsRental = carRental.nextLine();
    String roadsideAssistance = carRental.nextLine();

    int customersAge = carRental.nextInt();
    int lengthOfRental = carRental.nextInt();

    double totalToll = checkToll(tollTag, lengthOfRental);
    double totalGps = checkGps(gpsRental, lengthOfRental);
    double totalRoadside = checkRoadside(roadsideAssistance, lengthOfRental);
    double totalSurcharge = surchargeCalculated(customersAge, lengthOfRental);
    double totalOptions = optionsCalculated(totalToll, totalGps, totalRoadside);
    double totalBase = getBaseRental(lengthOfRental);

    System.out.println("The rental starts on " + pickUpDate);
    System.out.println("Basic Rent fee: $" + String.format("%.2f", totalBase));
    System.out.println("Options cost: $" + String.format("%.2f", totalOptions));
    System.out.println("Under age surcharge: $" + String.format("%.2f", totalSurcharge));
    System.out.println(
        "The total rental cost is: $" + String.format("%.2f", getRentalTotal(totalBase, totalOptions, totalSurcharge)));

  }

  public static double dailyBase = 29.99;
  public static double dailyToll = 3.95;
  public static double dailyGps = 2.95;
  public static double dailyRoadside = 3.95;
  public static double ageSurcharge = 0.3;

  public static double getBaseRental(int days) {
    return dailyBase * days;
  }

  public static double optionsCalculated(double toll, double gps, double roadside) {
    return toll += gps += roadside;
  }

  public static double checkToll(String toll, int days) {
    if (toll.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyToll * days;
    }
  }

  public static double checkGps(String gps, int days) {
    if (gps.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyGps * days;
    }
  }

  public static double checkRoadside(String roadside, int days) {
    if (roadside.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyRoadside * days;
    }
  }

  public static double surchargeCalculated(int age, int days) {
    if (age < 25) {
      double baseCharge = days * dailyBase;
      return baseCharge * ageSurcharge;
    } else {
      return 0.00;
    }
  }

  public static double getRentalTotal(double base, double options, double surcharge) {
    return base += options += surcharge;
  }
}
