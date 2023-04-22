package tests.data.values;

public enum StateAndCityPracticeForm {

    STATE_NCR("NCR", new String[]{ "Delhi", "Gurgaon", "Noida" }),
    STATE_UTTAR_PRADESH("Uttar Pradesh", new String[]{ "Lucknow", "Merrut", "Agra" }),
    STATE_HARYANA("Haryana", new String[]{ "Karnal", "Panipat" }),
    STATE_RAJASTHAN("Rajasthan", new String[]{ "Jaipur", "Jaiselmer" });

    private String state;
    private String[] city;

    StateAndCityPracticeForm(String state, String[] city) {
        this.state = state;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public String[] getCity() {
        return city;
    }

}
