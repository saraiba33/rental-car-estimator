import java.util.Scanner;

class App {
  public static void main(String args[]) {

    System.out.println(dateReponse());
    System.out.println(tollResponse());
    System.out.println(gpsResponse());
    System.out.println(roadsideResponse());
    System.out.println(AgeResponse());
    System.out.println(lengthResponse());
    // System.out.println("The rental starts on " + dateReponse());
    // System.out.println("Basic Rent fee: $" + String.format("%.2f", totalBase));
    // System.out.println("Options cost: $" + String.format("%.2f", totalOptions));
    // System.out.println("Under age surcharge: $" + String.format("%.2f",
    // totalSurcharge));
    // System.out.println(
    // "The total rental cost is: $" + String.format("%.2f",
    // getRentalTotal(totalBase, totalOptions, totalSurcharge)));

  }

  private static String dateReponse() {
    Scanner pickUpScanner = new Scanner(System.in);
    System.out.println("Pickup Date (ex: 05/24/22)");
    return pickUpScanner.nextLine();
  }

  private static String tollResponse() {
    Scanner tollScanner = new Scanner(System.in);
    System.out.println("Would you like Toll tag for $3.95/day? (yes/no)");
    return tollScanner.nextLine();
  }

  private static String gpsResponse() {
    Scanner gpsScanner = new Scanner(System.in);
    System.out.println("Would you like a gps for $2.95/day? (yes/no)");
    return gpsScanner.nextLine();

  }

  private static String roadsideResponse() {
    Scanner roadsideScanner = new Scanner(System.in);
    System.out.println("Would you like roadside assistance for $3.95/day? (yes/no)");
    return roadsideScanner.nextLine();
  }

  private static int AgeResponse() {
    Scanner ageScanner = new Scanner(System.in);
    System.out.println("Customers Age");
    return ageScanner.nextInt();
  }

  private static int lengthResponse() {
    Scanner lenghtScanner = new Scanner(System.in);
    System.out.println("How many days will you need the rental?");
    return lenghtScanner.nextInt();
  }

  public static double dailyBase = 29.99;
  public static double dailyTollAndRoadside = 3.95;
  public static double dailyGps = 2.95;
  public static double ageSurcharge = 0.3;

  public static double getBaseRental(int days) {
    return dailyBase * days;
  }

  public static double optionsCalculated(double toll, double gps, double roadside) {
    double tollAndGps = toll += gps;
    return tollAndGps += roadside;
  }

  public static double checkToll(String toll) {
    if (toll.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyTollAndRoadside * 1;
    }
  }

  public static double checkGps(String gps) {
    if (gps.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyGps * 1;
    }
  }

  public static double checkRoadside(String roadside) {
    if (roadside.equalsIgnoreCase("no")) {
      return 0.00;
    } else {
      return dailyTollAndRoadside * 1;
    }
  }

  public static double surchargeCalculated(int age) {
    if (age < 25) {
      double baseCharge = 1 * dailyBase;
      return baseCharge * ageSurcharge;
    } else {
      return 0.00;
    }
  }

  public static double getRentalTotal(double base, double options, double surcharge) {
    double baseAndOptions = base += options;
    return baseAndOptions += surcharge;
  }
}