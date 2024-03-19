CREATE OR REPLACE PROCEDURE check_room_availability(IN start_date DATE, IN end_date DATE)
LANGUAGE SQL
AS $$
SELECT *
FROM htl_room
WHERE (SELECT COALESCE(SUM(CASE WHEN  ((reservation_from <= start_date AND reservation_until >= end_date) OR
                                       (reservation_from >= start_date AND reservation_until <= end_date) OR
                                       (start_date >= reservation_from AND end_date >= reservation_until AND start_date < reservation_until) OR
                                       (start_date <= reservation_from AND end_date <= reservation_until AND end_date > reservation_from))
                                    THEN 1 ELSE 0 END), 0)
       FROM htl_reservation
       WHERE htl_reservation.room_id = htl_room.room_id) <= 0;
$$;