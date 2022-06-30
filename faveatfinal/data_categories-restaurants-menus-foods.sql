INSERT INTO categories(category_id,name_category,type)VALUES
(1,'Marino','2 tenedores'),
(2,'Pizzerias','Vegana');

INSERT INTO restaurants(restaurant_id,name_restaurants,locations, capacities, phones,images,start_time,end_time,category_id, restaurant_owner_id)VALUES
(1,'El Rincon del Pez','Barranca', 65, 980925812,'https://media-cdn.tripadvisor.com/media/photo-p/19/cb/d1/b4/del-m-a-r-a-su-paladar.jpg','09:00','17:00', 1,1),
(2,'Veggie Pizza','Miraflores', 65, 980925813,'https://bcassetcdn.com/public/blog/wp-content/uploads/2019/09/18094304/vegan-pizzeria.png','14:00','22:00', 1,1);

INSERT INTO menu_restaurants(menu_restaurant_id,type_menu_restaurant,descriptions, restaurant_id)VALUES
(1,'Entradas','Acompaña tu plato favorito con estas entradas',1),
(2,'Ceviches','Variedad de ceviches con producto fresco',1),
(3,'Trilogías Marinas','Trio Marino con el toque de la casa',1),
(4,'Chicharrones y Fritos','Para acompañar tu plato',1),
(5,'Pizzas Clásicas','Gran variedad de pizzas clasicas',2),
(6,'Pizzas Veggies','Pizzas con un toque saludable',2);

INSERT INTO foods(id,name,costs,descriptions,images,stocks,menu_restaurant_id)VALUES
(1,'Ceviche de Lenguado',30.0, 'Ingredientes: Filete de Lenguado, Camote, Choclo, Cebolla, Limon','https://images.unsplash.com/photo-1535399831218-d5bd36d1a6b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',5, 2),
(2,'Ceviche de Pescado',26.0, 'Ingredientes: Filete de Pescado Corvina, Camote, Choclo, Cebolla, Limon','https://t2.rg.ltmcdn.com/es/posts/7/4/1/ceviche_peruano_18147_600.jpg',10, 2),
(3,'Ceviche de Pescado con Pulpo',28.0,'Ingredientes: Filete de Pescado Corvina, Pulpo, Camote, Choclo, Cebolla, Limon','https://micevichedehoy.com/wp-content/uploads/2018/09/ceviche-de-pulpo_700x465.jpg',12,2),
(4,'Ceviche Mixto Especial',36.0,'Ingredientes: Calamar, Conchas de abanico, Pulpo, Camaron, Filete de Pescado,Camote, Cebolla, Limon','https://micevichedehoy.com/wp-content/uploads/2018/09/ceviche-mixto_700x467.jpg',10,2),
(5,'Ceviche Carretillero',26.0,'Ingredientes: Filete de Pescado, Pota, Lechuga,Camote, Cebolla, Limon, Cancha Serrana','https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467.jpg',12,2),
(6,'Leche de Tigre',18.0, 'Ingredientes: Filete de merluza, Cancha Serrana, Cebolla, Limon','https://www.comeperuano.pe/wp-content/uploads/2020/03/leche-de-tigre11.jpg.webp',21, 1),
(7,'Causa con langostino',26.0, 'Ingredientes: Papa amarilla, Limon, Aji amarillo, Palta, Langostino','https://kasani.pe/wp-content/uploads/2020/10/CAUSA-DE-LANGOSTINOS.jpg',12, 1),
(8,'Trio de Causa con langostino',32.0, 'Ingredientes: Ceviche de pescado, Chicharron de Pescado, Causa c/ langostino','https://media-cdn.tripadvisor.com/media/photo-s/11/d2/a7/98/trio-de-causas-de-langostinos.jpg',10, 3),
(9,'Trio de Chaufa con Mariscos',26.0, 'Ingredientes: Ceviche de pescado, Chicharron de Pescado, Arroz chaufa c/ mariscos','https://cuponassets.cuponatic-latam.com/backendPe/uploads/imagenes_descuentos/92229/0788e68bf56e919cb217f1570d6496525e66619b.XL2.jpg',12, 3),
(10,'Chicharron de Pescado',27.0, 'Ingredientes: Chicharron de Pescado, Mayonesa, Cebolla','https://cocina-casera.com/wp-content/uploads/2018/01/Chicharr%C3%B3n-de-pescado.jpg',23, 4),
(11,'Chicharron Mixto Especial',28.0, 'Ingredientes: Filete de pescado, Chicharron de Pescado, Conchas negras, langostino','https://i0.wp.com/www.berypez.pe/wp-content/uploads/2020/06/p03-fuente-chicharron-mixto.jpg?fit=900%2C600&ssl=1',25, 4),
(12,'Pizza Americana',48.0, 'Pizza con doble jamón inglés, mozzarella fiordilatte y queso grana padano.','https://images.rappi.pe/products/ef949279-bd98-4f34-b8cd-1d860b2b6756-1649907760574.png?d=128x104&?d=1920xundefined&e=webp',35, 5),
(13,'Hawaiian Party',50.0, 'Pizza con piña en almíbar, jamón inglés, mozzarella fiordilatte y mermelada de sauco.','https://images.rappi.pe/products/fc62bf82-31c9-43d3-b119-b1f917e46670-1649908038114.png?d=128x104&?d=1920xundefined&e=webp',20, 5),
(14,'Avocado Garden-nuevo',54.0, 'Pizza con full palta en cubos, tomate italiano, cebolla blanca y queso grana padano.','https://images.rappi.pe/products/9ad2aeac-ffdd-469d-8264-2418bfa28755-1649908405500.png?d=128x104&?d=1920xundefined&e=webp',13, 6),
(15,'Margarita 5 Quesos',50.0, 'Pizza con tomate en rodajas, mozzarella fiordilatte y mix de 4 quesos de la casa.','https://images.rappi.pe/products/76a110eb-0d71-41dc-ac85-0efc51703edc-1649908490535.png?d=128x104&?d=1920xundefined&e=webp',19, 6);

