package tables;

/**
 * @author hyc
 * @date 2020/5/8
 */
//水浒英雄
public class ShuihuHero {
    private int id;//排行
    private String name;//姓名
    private String nickname;//称号
    private String constellation;//星宿

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public ShuihuHero(int id, String name, String nickname, String constellation) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.constellation = constellation;
    }

    public ShuihuHero() {
    }

    @Override
    public String toString() {
        return "ShuihuHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", constellation='" + constellation + '\'' +
                '}';
    }
}
