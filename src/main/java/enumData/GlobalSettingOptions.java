package enumData;


public enum GlobalSettingOptions {
    ADD_PAGE("Add Page"),
    CREATE_PROFILE("Create Profile"),
    CREATE_PANEL("Create Panel"),
    EDIT("Edit"),
    DELETE("Delete");

    private String settingOption;

    private GlobalSettingOptions(String settingOption) {
        this.settingOption = settingOption;
    }

    // getter & setter
    public String getSettingOption() {
        return settingOption;
    }

    public void setSettingOption(String settingOption) {
        this.settingOption = settingOption;
    }
}
