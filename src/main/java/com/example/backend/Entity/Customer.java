package com.example.backend.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "customer")
/*@Getter//через lombok = public Long getId(){return id}
@Setter//через lombok = public Long setId(Long id){this.id = id}
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@NoArgsConstructor//возможно нужно будет удалить
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false, length = 50)
    @NonNull
    private String name;

    @Column(nullable = false, length = 50)
    @NonNull
    private String surname;

    @Column(unique = true, nullable = false, length = 100)
    @NonNull
    private String email;

    @Column(nullable = false)
    @Setter(AccessLevel.PROTECTED)
    @NonNull
    private String password;

    @OneToMany(mappedBy = "cart_id", fetch = FetchType.LAZY)
    private Set<ShoppingCart> shoppingCarts;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
