CREATE PROC sp_addCustomer (
	@fullname NVARCHAR(250),
	@username NVARCHAR(100),
	@password NVARCHAR(100),
	@phoneNumber NVARCHAR(100),
	@address NVARCHAR(250),

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
	(@newID, @fullname, @username, @password, @phoneNumber, @address, NEWID());

	SET @id = @newID;

END


EXEC sp_addCustomer N'Tớ tên Hạnh', 'test', 'hanh', '0123456789', N'Việt Nam';