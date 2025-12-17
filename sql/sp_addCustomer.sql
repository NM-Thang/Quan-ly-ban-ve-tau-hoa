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

EXEC sp_addEmPloyee N'Hoàng Thu Hạnh', 'hanhht', 'hanhht', 12000000, '0363676283'