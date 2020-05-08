package io.dolphin.common.xss;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * @Description: 描述: 过滤 HTML 标签中 XSS 代码
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:21
 */
public class XssUtil {
    /**
     * 使用自带的 basicWithImages 白名单
     */
    private static final Whitelist WHITE_LIST = Whitelist.relaxed();
    /** 配置过滤化参数, 不对代码进行格式化 */
    private static final Document.OutputSettings OUTPUT_SETTINGS = new Document.OutputSettings().prettyPrint(false);
    static {
        // 富文本编辑时一些样式是使用 style 来进行实现的
        // 比如红色字体 style="color:red;"
        // 所以需要给所有标签添加 style 属性
        WHITE_LIST.addAttributes(":all", "style");
    }
    public static String clean(String content) {
        return Jsoup.clean(content, "", WHITE_LIST, OUTPUT_SETTINGS);
    }
}
