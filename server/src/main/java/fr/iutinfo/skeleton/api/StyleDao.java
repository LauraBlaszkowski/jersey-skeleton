package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface StyleDao {
    @SqlUpdate("create table styles (id integer primary key autoincrement, couleur varchar(100), police varchar(50), taille varchar(3), espacement_caractere varchar(3), espacement_ligne varchar(3), espacement_mot varchar(3))")
    void createStyleTable();

    @SqlUpdate("insert into styles (couleur, police, taille, espacement_caractere, espacement_ligne, espacement_mot) values (:couleur, :police, :taille, :espacement_caractere, :espacement_ligne, :espacement_mot)")
    @GetGeneratedKeys
    int insert(@BindBean() Style style);

    @SqlQuery("select * from styles where search like :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Style> search(@Bind("name") String name);

    @SqlUpdate("drop table if exists styles")
    void dropStyleTable();

    @SqlUpdate("delete from styles where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from styles order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Style> all();
    
    @SqlUpdate("select * from styles where couleur = :couleur and police = :police and taille = :taille and espacement_caractere = :espacement_caractere and espacement_ligne = :espacement_ligne and espacement_mot = :espacement_mot")
    @GetGeneratedKeys
    Style find(@BindBean() Style style);

    @SqlQuery("select * from styles where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Style findById(@Bind("id") int id);

    void close();
}
