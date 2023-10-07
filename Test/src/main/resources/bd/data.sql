IF NOT EXISTS (SELECT 1 FROM distrito WHERE distrito_id = 1 AND distrito_nombre = 'Lima')
BEGIN INSERT distrito (distrito_id, distrito_nombre) VALUES (1, 'Lima') END;

IF NOT EXISTS (SELECT 1 FROM distrito WHERE distrito_id = 2 AND distrito_nombre = 'Miraflores')
BEGIN INSERT distrito (distrito_id, distrito_nombre) VALUES (2, 'Miraflores') END;

IF NOT EXISTS (SELECT 1 FROM distrito WHERE distrito_id = 3 AND distrito_nombre = 'San Isidro')
BEGIN INSERT distrito (distrito_id, distrito_nombre) VALUES (3, 'San Isidro') END;

IF NOT EXISTS (SELECT 1 FROM distrito WHERE distrito_id = 4 AND distrito_nombre = 'Jesus Maria')
BEGIN INSERT distrito (distrito_id, distrito_nombre) VALUES (4, 'Jesus Maria') END;

IF NOT EXISTS (SELECT 1 FROM distrito WHERE distrito_id = 5 AND distrito_nombre = 'Pueblo Libre')
BEGIN INSERT distrito (distrito_id, distrito_nombre) VALUES (5, 'Pueblo Libre') END;