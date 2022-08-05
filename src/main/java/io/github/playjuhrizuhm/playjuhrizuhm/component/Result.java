package io.github.playjuhrizuhm.playjuhrizuhm.component;

public class Result {
    String playContent,source;
    double percentage;

    public String getPlayContent() {
        return playContent;
    }

    public void setPlayContent(String playContent) {
        this.playContent = playContent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Result(String playContent, String source, double percentage) {
        this.playContent = playContent;
        this.source = source;
        this.percentage = percentage;
    }
}
