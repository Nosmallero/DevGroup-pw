INSERT INTO payment_type(id, name_payment_type, detail) VALUES
	(1, 'Tarjeta de debito', 'Puedes realizar pagos y transferencias'),
	(2, 'Tarjeta de credito', 'Créditos bienes o pagar a crédito por servicios'),
	(3, 'Efectivo', 'Puedes pagar con dinero en agentes');
	
INSERT INTO reservation_payment(id, name_reservation, payment_amount, payment_type_id) VALUES
	(1, 'Pago de 2 mesa', 58, 3),
	(2, 'Pago de 3 mesas', 20, 1),
	(3, 'Pago de 4 mesas', 21, 2);