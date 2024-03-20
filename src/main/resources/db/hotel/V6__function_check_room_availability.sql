CREATE OR REPLACE FUNCTION check_room_availability_v2(startDate DATE, endDate DATE)
    RETURNS TABLE (
                      room_id BIGINT,
                      room_type_id BIGINT,
                      room_code VARCHAR(20),
                      htl_level INT
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT htl_room.*
        FROM htl_room
        WHERE (SELECT COALESCE(SUM(CASE WHEN  ((reservation_from <= startDate AND reservation_until >= endDate) OR
                                               (reservation_from >= startDate AND reservation_until <= endDate) OR
                                               (startDate >= reservation_from AND endDate >= reservation_until AND startDate < reservation_until) OR
                                               (startDate <= reservation_from AND endDate <= reservation_until AND endDate > reservation_from))
                                            THEN 1 ELSE 0 END), 0)
               FROM htl_reservation
               WHERE htl_reservation.room_id = htl_room.room_id) <= 0;

END;
$$ LANGUAGE plpgsql;