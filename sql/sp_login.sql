CREATE PROC sp_login(
	@username NVARCHAR(100),
	@password NVARCHAR(100),
	@type NVARCHAR(100)
)
AS
BEGIN
	IF (@type = 'Employee')
		BEGIN
			SELECT * FROM [dbo].[Employee] WHERE @username = username AND @password = password
		END
	ELSE
		BEGIN
			SELECT * FROM [dbo].[Customer] WHERE @username = username AND @password = password
		END
END


EXEC sp_login 'testhanh', 'hanhne', 'Customer'
