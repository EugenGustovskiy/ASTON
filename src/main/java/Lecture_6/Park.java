package Lecture_6;

import java.math.BigDecimal;

public class Park {
    private String parkName;
    private Attraction[] attractions;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public String getParkName(){
        return parkName;
    }

    public void addAttractionsToThePark(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public void displayInformationAboutAllAttractions() {
        System.out.println("Парк: " + getParkName());
        for (int i = 0; i < attractions.length; i++) {
            attractions[i].displayAllInformationAboutAttraction();
            if (i < attractions.length - 1) {
                System.out.println("* * *");
            }
        }
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private BigDecimal cost;

        public Attraction(String name, String workingHours, BigDecimal cost) {
            this.attractionName = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void displayAllInformationAboutAttraction() {
            System.out.printf("Название аттракциона: %s\nВремя работы: %s\nСтоимость: %s\n",
                    attractionName, workingHours, cost.toString());
        }
    }
}