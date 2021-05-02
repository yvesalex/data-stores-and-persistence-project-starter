package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PetDAOImpl implements PetDAO{
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    String SELECT_QUERY = "select * from pet";
    String SELECT_BY_ID_QUERY = " where id = :id";
    String ADD_QUERY = "";

    private static  final RowMapper<PetData> petRowMapper = new BeanPropertyRowMapper<>(PetData.class);

    @Override
    public List<PetData> getAll() {
        return jdbcTemplate.query(SELECT_QUERY, petRowMapper);
    }

    @Override
    public PetData findById(long id) {
        return (PetData) jdbcTemplate.query(SELECT_BY_ID_QUERY,
                new MapSqlParameterSource("id", id),
                petRowMapper);
    }

    @Override
    public long savePet(PetData petData) {
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_QUERY, new BeanPropertySqlParameterSource(petData), key);
        return key.getKey().longValue();
    }
}
