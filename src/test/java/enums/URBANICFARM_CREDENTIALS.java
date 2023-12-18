package enums;

import lombok.Getter;

@Getter
public enum URBANICFARM_CREDENTIALS {

    SELLER("seller_urban@mailsac.com","VHt*zzt*wQNu6XS"),
    BUYER("buyer_urban@mailsac.com", "VHt*zzt*wQNu6XS");



    private final String username;
    private final String password;

    URBANICFARM_CREDENTIALS(String username, String password) {
        this.username = username;
        this.password=password;
    }

    public void login(){
        System.out.println(this.username+ " " + this.password);
    }

}
