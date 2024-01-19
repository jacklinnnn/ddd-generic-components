package top.austin.core;

/**
 * @Desc: 分布式ID生成器
 * @author: Linbizhao
 * @since: 2024/1/19 0:52
 */
public interface IdGenerator {

    /**
     * 下一个 ID
     */
    default long nextId() {
        return 0L;
    }

    /**
     * 下一个 ID 字符串
     */
    default String nextIdStr() {
        return "";
    }
}
