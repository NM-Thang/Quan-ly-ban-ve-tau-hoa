
----------------------------LOGIN EMPLOYEE------------------------------------------

CREATE PROC sp_loginEmployee(
	@username NVARCHAR(100),
	@password NVARCHAR(100)
)
AS
BEGIN
		SELECT 
			e.id AS idEmployee, 
			e.fullname AS fullname, 
			e.salary AS salary, 
			e.role AS role, 
			e.phoneNumber AS phoneNumberEmployee, 
			b.id AS idBranch,
			b.address AS addressBranch,
			b.phoneNumber AS phoneNumberBranch
		FROM [dbo].[Employee] AS e
		INNER JOIN [dbo].[Branch] AS b ON e.idBranch = b.id
		WHERE @username = e.username AND @password = e.password
END



------------------------LOGIN CUSTOMER--------------------------

CREATE PROC sp_loginCustomer(
	@username NVARCHAR(100),
	@password NVARCHAR(100)
)
AS
BEGIN
	SELECT 
		c.id AS idCustomer, 
		c.fullname AS fullname, 
		c.phoneNumber AS phoneNumberCustomer, 
		c.address AS addressCustomer,
		b.id AS idBranch,
		b.address AS addressBranch,
		b.phoneNumber AS phoneNumberBranch
	FROM [dbo].[Customer] AS c
	INNER JOIN [dbo].[Branch] AS b ON c.idBranch = b.id
	WHERE @username = c.username AND @password = c.password
END





--------------------ADD CUSTOMER----------------------------

CREATE PROC sp_addCustomer (
	@fullname NVARCHAR(250),
	@username NVARCHAR(100),
	@password NVARCHAR(100),
	@phoneNumber NVARCHAR(100),
	@address NVARCHAR(250),
	@idBranch VARCHAR(10),
	@id NVARCHAR(10) OUTPUT
)
AS
BEGIN
	DECLARE @maxID INT;
	DECLARE @newID VARCHAR(10);
	DECLARE @brandID VARCHAR(2);

	SELECT @brandID = id FROM [dbo].[Branch];
	SELECT @maxID = COUNT(id) FROM [dbo].[Customer] WHERE id LIKE '%' + @brandID + '%' ;

	SET @newID = 'C' + @brandID +   RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);


	INSERT INTO [dbo].[Customer] VALUES
	(@newID, @fullname, @username, @password, @phoneNumber, @address, @idBranch, NEWID());

	SET @id = @newID;

END


EXEC sp_addCustomer N'Tớ tên Hạnh', 'test', 'hanh', '0123456789', N'Việt Nam';





-------------------ADD EMPLOYEE----------------------------


CREATE PROC sp_addEmPloyee(
	@fullname NVARCHAR(250),
	@username NVARCHAR(100),
	@password NVARCHAR(100),
	@salary INT,
	@phoneNumber NVARCHAR(20)
)
AS
BEGIN
	DECLARE @maxID INT;
	DECLARE @newID VARCHAR(10);
	DECLARE @brandID VARCHAR(2);

	SELECT @brandID = id FROM [dbo].[Branch];
	SELECT @maxID = COUNT(id) FROM [dbo].[Employee] ;

	SET @newID = 'E' + @brandID +   RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);

	INSERT INTO [dbo].[Employee] VALUES
	(@newID, @fullname, @username, @password, @salary, N'Nhân viên', @phoneNumber, @brandID, NEWID());

END



--------------------EDIT CUSTOMER---------------------------


CREATE PROC sp_editCustomer(
	@id NVARCHAR(10),
	@fullname NVARCHAR(250),
	@username NVARCHAR(100),
	@password NVARCHAR(100),
	@phoneNumber NVARCHAR(100),
	@address NVARCHAR(250),

	@status NVARCHAR(250) OUTPUT
)
AS
BEGIN TRY
	UPDATE [dbo].[Customer]
	SET fullname = @fullname,
		username = @username,
		password = @password,
		phoneNumber = @phoneNumber,
		address = @address
	WHERE id = @id;

	SET @status = 'success'
END TRY
BEGIN CATCH
	SET @status = 'failure'
END CATCH



DECLARE @status NVARCHAR(250)
EXEC @status = sp_editCustomer 'CHP020', N'Nguyễn Anh Huy', 'Huynaptit', '123', '0123456789', N'Trung quốc', @status OUTPUT
PRINT @status



--------------------------getListTicketedCustomer--------------------------------
CREATE PROC sp_getListTicketedCustomer (
	@idCustomer NVARCHAR(10)
)
AS
BEGIN
	SELECT	Ticket.id AS 'idTicket', 
			Ticket.totalAmount AS 'totalAmount',
			TrainRide.idTrain AS 'idTrain', 
			startStation.name AS 'startStation', 
			endStation.name AS 'endStation', 
			TrainRide.departureTime AS 'startTime', 
			Ticket.seatType AS 'seatType'
	FROM [LINK_TO_SERVER_TIEN].[QLBVTH].[dbo].[Ticket] AS Ticket
	INNER JOIN [LINK_TO_SERVER_TIEN].[QLBVTH].[dbo].[TrainRide] AS TrainRide ON Ticket.idTrainRide = TrainRide.id
	INNER JOIN [LINK_TO_SERVER_TIEN].[QLBVTH].[dbo].[Station] AS startStation ON TrainRide.idDepartureStation = startStation.id
	INNER JOIN [LINK_TO_SERVER_TIEN].[QLBVTH].[dbo].[Station] AS endStation ON TrainRide.idDestinationStation = endStation.id
	WHERE Ticket.idCustomer = @idCustomer
END

EXEC sp_getListTicketedCustomer 'CHP009'




-----------------------GET STATION--------------------------------
CREATE PROC sp_getAllStaion 
AS 
BEGIN
	SELECT * FROM Station
END

SELECT * FROM Station



------------------------sp_getListTrainRide---------------------

CREATE PROC sp_getListTrainRide (
	@nameStartStaion NVARCHAR(100),
	@nameEndStation NVARCHAR(100	)
)
AS
BEGIN

	SELECT	*
	FROM [dbo].[TrainRide] 
	WHERE TrainRide.idDepartureStation = (SELECT Station.id FROM Station WHERE Station.name = @nameStartStaion)
		AND TrainRide.idDestinationStation = (SELECT Station.id FROM Station WHERE Station.name = @nameEndStation)
END