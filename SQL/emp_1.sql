CREATE TABLE `test_consultas`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE);

-- ALTER TABLE `test_consultas`.`productos` 
--   CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;  

  /*
  * INSERTS
  */
/*
  INSERT INTO `test_consultas`.`empresas` (`nombre`) VALUES ('Data');
  INSERT INTO `test_consultas`.`empresas` (`nombre`) VALUES ('Otro');
*/
  -- --------------------------------------------------------------------------------------
  -- --------------------------------------------------------------------------------------
  CREATE TABLE `test_consultas`.`empresas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE);
  
  /*
  * INSERTS
  */
/*  
  INSERT INTO `test_consultas`.`productos` (`nombre`, `valor`) VALUES ('Recargas', '2000');
  INSERT INTO `test_consultas`.`productos` (`nombre`, `valor`) VALUES ('Recaudos', '3000');
*/
  -- --------------------------------------------------------------------------------------
  -- --------------------------------------------------------------------------------------
  CREATE TABLE `test_consultas`.`transacciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `empresa_id` INT NOT NULL,
  `producto_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `valor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_empresas_idx` (`empresa_id` ASC) VISIBLE,
  INDEX `FK_productos_idx` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `FK_empresas`
    FOREIGN KEY (`empresa_id`)
    REFERENCES `test_consultas`.`empresas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_productos`
    FOREIGN KEY (`producto_id`)
    REFERENCES `test_consultas`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
      
  /*
  * INSERTS
  */
/*
  INSERT INTO `test_consultas`.`transacciones` (`fecha`, `hora`, `empresa_id`, `producto_id`, `cantidad`, `valor`) 
  VALUES ('2022-07-12', '8:00:00', '1', '1', '1', '2000');
INSERT INTO `test_consultas`.`transacciones` (`fecha`, `hora`, `empresa_id`, `producto_id`, `cantidad`, `valor`) 
  VALUES ('2022-07-12', '8:10:00', '1', '1', '2', '4000');
INSERT INTO `test_consultas`.`transacciones` (`fecha`, `hora`, `empresa_id`, `producto_id`, `cantidad`, `valor`) 
  VALUES ('2022-07-12', '8:05:00', '1', '1', '3', '6000');
INSERT INTO `test_consultas`.`transacciones` (`fecha`, `hora`, `empresa_id`, `producto_id`, `cantidad`, `valor`) 
  VALUES ('2022-07-12', '8:07:00', '2', '2', '1', '3000');
INSERT INTO `test_consultas`.`transacciones` (`fecha`, `hora`, `empresa_id`, `producto_id`, `cantidad`, `valor`) 
  VALUES ('2022-07-12', '8:08:00', '2', '1', '2', '4000');
*/  
  -- --------------------------------------------------------------------------------------
  -- --------------------------------------------------------------------------------------


SELECT e.nombre, p.nombre, p.valor, sum(t.cantidad) cantidad, sum(p.valor * t.cantidad) AS valor_total
FROM transacciones as t
INNER JOIN empresas AS e ON t.empresa_id = e.id
INNER JOIN productos AS p ON t.producto_id = p.id
GROUP BY e.nombre, p.nombre
HAVING valor_total >= 3000
ORDER BY e.nombre ASC



  
  
  
  
  
  
  
  
  
  