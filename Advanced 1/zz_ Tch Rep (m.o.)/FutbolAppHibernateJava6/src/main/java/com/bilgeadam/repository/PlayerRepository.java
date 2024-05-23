package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Player;
import com.bilgeadam.repository.entity.PlayerPositions;
import com.bilgeadam.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerRepository extends MyFactoryRepository<Player, Long> {

    public PlayerRepository() {
        super(new Player());
    }


    public List<Player> findAllByPositionName(PlayerPositions ps) {
        CriteriaQuery<Player> criteria = getCriteriaBuilder().createQuery(Player.class);
        Root<Player> root = criteria.from(Player.class);
        criteria.select(root).where(getCriteriaBuilder().equal(root.get("player_positions"), ps));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    public List<Player> findByPosition(String position) {
        TypedQuery<Player> typedQuery = getEntityManager().createNamedQuery("findByPosition", Player.class);
        typedQuery.setParameter("position", PlayerPositions.valueOf(position));
        return typedQuery.getResultList();
    }

    public List<Player> findByMidfillerPlayer() {
        CriteriaQuery<Player> criteria = getCriteriaBuilder().createQuery(Player.class);
        Root<Player> root = criteria.from(Player.class);
        //CM, CDM, CAM, RM, LM
        List<PlayerPositions> playerPositions = List.of(PlayerPositions.CM,
                PlayerPositions.CDM, PlayerPositions.RM,
                PlayerPositions.CAM, PlayerPositions.LM);

        criteria.select(root).where(getCriteriaBuilder()
                .in(root.get("player_positions")).value(playerPositions));

        // criteria.select(root).where(root.get("player_positions").in(playerPositions));

        return getEntityManager().createQuery(criteria).getResultList();
    }

    public List<Player> findByMid() {
        TypedQuery<Player> typedQuery = getEntityManager().createNamedQuery("findByMid", Player.class);
        return typedQuery.getResultList();
    }

    public List<Player> findByArea(String area) {
        CriteriaQuery<Player> criteria = getCriteriaBuilder().createQuery(Player.class);
        Root<Player> root = criteria.from(Player.class);
        List<PlayerPositions> playerPositions = Arrays.asList(PlayerPositions.values()).stream()
                .filter(x -> x.getArea().equals(area)).collect(Collectors.toList());
        criteria.select(root).where(getCriteriaBuilder()
                .in(root.get("player_positions")).value(playerPositions));
        // criteria.select(root).where(root.get("player_positions").in(playerPositions));
        return getEntityManager().createQuery(criteria).getResultList();
    }



}
