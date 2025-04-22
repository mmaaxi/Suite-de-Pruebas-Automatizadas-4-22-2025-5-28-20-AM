Feature: Validar la inserción de 'Monto acumulado Folio Reserva 5401'

  Scenario: Exportar reporte y verificar el monto acumulado
    Given el usuario está en la página de reportes
    When el usuario ejecuta la exportación del reporte
    Then se añade una columna 'Monto acumulado Folio Reserva 5401' a la derecha de 'Monto (reserva)'
    And la columna muestra la suma correcta de los montos acumulados