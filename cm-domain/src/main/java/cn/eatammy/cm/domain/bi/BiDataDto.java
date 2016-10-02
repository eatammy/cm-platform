package cn.eatammy.cm.domain.bi;

/**
 * Created by 郭旭辉 on 2016/9/27.
 * 数据填充类
 */
public class BiDataDto {
    private String content;
    private String rate;
    private Integer upOrDown;
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(Integer upOrDown) {
        this.upOrDown = upOrDown;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
