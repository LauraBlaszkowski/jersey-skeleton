package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ProfilDao {
    @SqlUpdate("create table profils (id integer primary key autoincrement, name varchar(100), proprio Integer, description varchar(150))")
    void createProfilTable();

    @SqlUpdate("insert into profils (name, proprio, description) values (:name, :proprio, :description)")
    @GetGeneratedKeys
    int insert(@BindBean() Profil profil);

    @SqlQuery("select * from profils where name = :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Profil findByName(@Bind("name") String name);

    @SqlQuery("select * from profils where search like :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Profil> search(@Bind("name") String name);

    @SqlUpdate("drop table if exists profils")
    void dropProfilTable();

    @SqlUpdate("delete from profils where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from profils order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Profil> all();
    
    @SqlQuery("select * from profils where proprio = :proprio")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Profil> findByProprio(@Bind("proprio") int proprio);

    @SqlQuery("select * from profils where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Profil findById(@Bind("id") int id);

    void close();
}
