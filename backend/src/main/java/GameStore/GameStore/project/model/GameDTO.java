package GameStore.GameStore.project.model;

import java.sql.Date;

public record GameDTO(String name, Date date_published, int copies_sold, int no_achivements, User user){}