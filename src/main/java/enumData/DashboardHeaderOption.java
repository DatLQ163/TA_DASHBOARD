package enumData;

public enum DashboardHeaderOption {
    LAB_MANAGER("/LabManager/autologin.jsp?data=04947444145B51024243F3938310C0FEEF8FAE9CCDBC887FBA6A9A2BC8F828E8B71687F7E672D21"),
    HELP("help/Topics/Dashboard.html"),
    ADMINISTER("#Administer"),
    REPOSITORY("#Repository"),
    ADMINISTRATOR("#Welcome");

    private String href;

    private DashboardHeaderOption(String href) {
        this.href = href;
    }

    // getter & setter
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
