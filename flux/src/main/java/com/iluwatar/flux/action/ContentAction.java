package com.iluwatar.flux.action;

/**
 * Created by starhq on 2017/4/1.
 */
public class ContentAction extends Action {

    private Content content;

    public ContentAction(Content content) {
        super(ActionType.CONTENT_CHANGED);
        this.content = content;
    }

    public Content getContent() {
        return content;
    }
}
