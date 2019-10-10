package si.inspirited.persistence.model;

import org.jboss.aerogear.security.otp.api.Base32;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import si.inspirited.persistence.model.uniqueEntities.Ad;
import si.inspirited.persistence.model.uniqueEntities.UserPhoto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_account")
public class User implements UserDetails {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String email;    //name username

    private String phoneNumber;

    @Column(length = 60)
    private String password;

    private boolean enabled;

    private boolean isUsing2FA;

    private String secret;

    @OneToOne //(mappedBy = "userPhotos")
    private UserPhoto mainUserPhoto;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "inf_users_photos", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "inf_user_photo_id", referencedColumnName = "id"))
    public Collection<UserPhoto> userPhotos;

    //

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "inf_users_ads", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "inf_ad_id", referencedColumnName = "id"))
    public Collection<Ad> ads;

    public User() {
        super();
        this.secret = Base32.random();
        this.enabled = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() { return secondName; }

    public void setSecondName(String secondName) { this.secondName = secondName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String username) {
        this.email = username;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }




    public String getName() {
        return email;
    }

    public void setName(String name) {
        this.email = name;
    }


    // addition for User Details Interface

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return getRoles();

    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();              //this was hack for making search bY unique field
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }
    // end of addition for User Details Interface




    public void setPassword(final String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public void setUsing2FA(boolean isUsing2FA) {
        this.isUsing2FA = isUsing2FA;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


    /* extra fields added - inf_ad and inf_user_photo*/

    public Collection<Ad> getAds() {
        return ads;
    }

    public void setAds(Collection<Ad> ads) {
        this.ads = ads;
    }

    public Collection<UserPhoto> getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(Collection<UserPhoto> userPhotos) {
        this.userPhotos = userPhotos;
    }

    public UserPhoto getMainUserPhoto() {
        return mainUserPhoto;
    }

    public void setMainUserPhoto(UserPhoto mainUserPhoto) {
        this.mainUserPhoto = mainUserPhoto;
    }
    /*end of extra fields (inf_ad and inf_user_photo)*/


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=").append(lastName).append(", email=").append(email).append(", password=").append(password).append(", enabled=").append(enabled).append(", isUsing2FA=")
                .append(isUsing2FA).append(", secret=").append(secret).append(", roles=").append(roles).append("]");
        return builder.toString();
    }
}
