class SoilAnalysis {
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    public SoilAnalysis(String farmerId, String districtName,
                        double nitrogenLevel, double phosphorusLevel,
                        double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public double getNitrogenLevel() {
        return nitrogenLevel;
    }

    public double getPhosphorusLevel() {
        return phosphorusLevel;
    }

    public double getPotassiumLevel() {
        return potassiumLevel;
    }

    public String getCropType() {
        return cropType;
    }

    public boolean isBalanced() {
        return nitrogenLevel >= 20 && nitrogenLevel <= 100 &&
                phosphorusLevel >= 20 && phosphorusLevel <= 100 &&
                potassiumLevel >= 20 && potassiumLevel <= 100;
    }

    public String calculateFertilizerNeeded() {
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }

        if (isBalanced()) {
            return "OPTIMAL - Maintenance fertilizer only";
        }

        StringBuilder deficientNutrients = new StringBuilder();
        StringBuilder excessNutrients = new StringBuilder();

        if (nitrogenLevel < 20) {
            deficientNutrients.append("Nitrogen");
        } else if (nitrogenLevel > 100) {
            excessNutrients.append("Nitrogen");
        }

        if (phosphorusLevel < 20) {
            if (deficientNutrients.length() > 0) deficientNutrients.append(", ");
            deficientNutrients.append("Phosphorus");
        } else if (phosphorusLevel > 100) {
            if (excessNutrients.length() > 0) excessNutrients.append(", ");
            excessNutrients.append("Phosphorus");
        }

        if (potassiumLevel < 20) {
            if (deficientNutrients.length() > 0) deficientNutrients.append(", ");
            deficientNutrients.append("Potassium");
        } else if (potassiumLevel > 100) {
            if (excessNutrients.length() > 0) excessNutrients.append(", ");
            excessNutrients.append("Potassium");
        }

        if (deficientNutrients.length() > 0 && excessNutrients.length() > 0) {
            return "MIXED - High application needed for [" + deficientNutrients.toString() +
                    "] and reduce [" + excessNutrients.toString() + "] application";
        } else if (deficientNutrients.length() > 0) {
            return "DEFICIENT - High application needed for [" + deficientNutrients.toString() + "]";
        } else {
            return "EXCESS - Reduce [" + excessNutrients.toString() + "] application";
        }
    }
}

class FertilizerAdvisorySystem_24rp04674 {

    public static void processSamples(SoilAnalysis[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;
        int totalProcessed = 0;

        System.out.println("=== IhindukaConnect - Fertilizer Advisory Report ===");
        System.out.println("=====================================================");

        for (int i = 0; i < samples.length; i++) {
            SoilAnalysis sample = samples[i];
            System.out.println("\n--- Processing Sample " + (i + 1) + " ---");

            try {
                String recommendation = sample.calculateFertilizerNeeded();

                System.out.println("Farmer ID: " + sample.getFarmerId());
                System.out.println("District: " + sample.getDistrictName());
                System.out.println("Crop Type: " + sample.getCropType());
                System.out.println("Nutrient Levels - N: " + sample.getNitrogenLevel() +
                        " ppm, P: " + sample.getPhosphorusLevel() +
                        " ppm, K: " + sample.getPotassiumLevel() + " ppm");
                System.out.println("Recommendation: " + recommendation);

                if (sample.isBalanced()) {
                    balancedCount++;
                } else {
                    deficientCount++;
                }
                totalProcessed++;

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR processing sample for Farmer " + sample.getFarmerId() +
                        " in " + sample.getDistrictName() + ": " + e.getMessage());
                System.out.println("Invalid readings - N: " + sample.getNitrogenLevel() +
                        " ppm, P: " + sample.getPhosphorusLevel() +
                        " ppm, K: " + sample.getPotassiumLevel() + " ppm");
            }
        }

        System.out.println("\n=== PROCESSING SUMMARY ===");
        System.out.println("Total samples processed: " + totalProcessed);
        System.out.println("Balanced soil samples: " + balancedCount);
        System.out.println("Deficient/Excess soil samples: " + deficientCount);
        System.out.println("Samples with errors: " + (samples.length - totalProcessed));
    }

    public static void main(String[] args) {
        SoilAnalysis[] soilSamples = {
                new SoilAnalysis("F001", "Kirehe", 50, 70, 80, "Maize"),
                new SoilAnalysis("F002", "Bugesera", 10, 45, 60, "Rice"),
                new SoilAnalysis("F003", "Nyagatare", 110, 90, 85, "Beans"),
                new SoilAnalysis("F004", "Gatsibo", -5, 40, 60, "Maize"),
                new SoilAnalysis("F005", "Huye", 15, 15, 18, "Rice")
        };

        processSamples(soilSamples);
    }
}