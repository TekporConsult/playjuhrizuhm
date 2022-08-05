package io.github.playjuhrizuhm.playjuhrizuhm.component;

public class PlayComponent {
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

    public PlayComponent() {
    }

    public PlayComponent(String playContent, String source) {
        this.playContent = playContent;
        this.source = source;
    }

    String playContent,source;
}
