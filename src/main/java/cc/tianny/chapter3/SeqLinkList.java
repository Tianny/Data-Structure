package cc.tianny.chapter3;

/**
 * 顺序线性表
 * 顺序存储结构
 * 简单起见，使用类型为 String 的数组来模拟
 * 初始条件：顺序线性表 L 已经存在 && 1 <= pos <= L.length
 */
public class SeqLinkList {

    private int length;
    private final int maxSize;
    private final String[] seqString;

    // 对线性表做初始化操作，以满足：顺序线性表 L 已经存在 && 1 <= pos <= L.length
    public SeqLinkList(int maxSize, String str) {
        this.maxSize = maxSize;
        this.seqString = new String[maxSize];
        this.seqString[0] = str;
        this.length = 1;
    }

    // 获取操作
    public void get(int pos) {
        if (this.length == 0 || pos < 1 || pos > this.length) {
            System.out.println("Error");
        }
        String result = this.seqString[pos - 1];
        System.out.println("获取第 " + pos + " 位置的元素指为 " + result);
    }

    // 插入操作
    // 从顺序表尾部开始遍历，想想为什么？
    public void insert(int pos, String string) {

        if (this.length == this.maxSize) {
            System.out.println("顺序表长度已满，不能再插入新的节点");
            return;
        }

        if (pos < 1 || pos > this.length + 1) {
            System.out.println("插入位置不对");
            return;
        }

        if (pos <= this.length) {
            for (int k = this.length - 1; k >= pos - 1; k--) {
                this.seqString[k + 1] = this.seqString[k];
            }
            this.seqString[pos - 1] = string;
            this.length++;
        }

        System.out.println("插入第" + " " + pos + " " + "位置" + "[" + string + "]" + "后顺序表内容：");
        for (int i = 0; i < this.length; i++) {
            System.out.println(seqString[i]);
        }
    }

    // 删除操作
    // 从顺序表从前向后遍历，想想为什么
    public void delete(int pos) {
        if (this.length == 0) {
            System.out.println("顺序表为空，无法删除");
            return;
        }
        if (pos < 1 || pos > this.length + 1) {
            System.out.println("删除位置不正确");
            return;
        }
        // 从顺序表从前向后遍历，想想为什么
        for (int k = pos; k <= this.length - 1; k++) {
            this.seqString[k - 1] = this.seqString[k];
        }
        this.length--;

        System.out.println("删除第 " + pos + " 位置后顺序表内容: ");
        for (int i = 0; i < this.length; i++) {
            System.out.println(this.seqString[i] + " ");
        }
    }

    public static void main(String[] args) {
        SeqLinkList seqLinkList = new SeqLinkList(10, "0");
        seqLinkList.insert(1, "1");
        seqLinkList.insert(2, "2");
        seqLinkList.insert(3, "3");
        seqLinkList.insert(2, "4");
        seqLinkList.delete(2);
        seqLinkList.get(1);
        seqLinkList.get(2);
    }
}
