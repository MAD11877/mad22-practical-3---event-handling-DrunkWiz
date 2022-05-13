package sg.edu.np.mad.week2pracmadnathan;

public class User {
    private String Name;
    private String Description;
    private Long id;
    private Boolean followed;

    public User(){}

    public User(String name, String description, Long id, Boolean followed) {
        Name = name;
        Description = description;
        this.id = id;
        this.followed = followed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }
}
