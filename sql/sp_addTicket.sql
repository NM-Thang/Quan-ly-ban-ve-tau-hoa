CREATE PROC sp_addTicket(
	@idBranch VARCHAR(10),      ------idBranch của Station xuất phát để phân loại Ticket thuộc Branch nào--------

	@totalAmount INT,
	@idTrainRide VARCHAR(10),
	@idCustomer VARCHAR(10),
	@idEmployee VARCHAR(10),
	@seatType INT
)
AS

BEGIN

	DECLARE @maxID INT;
	DECLARE @newID VARCHAR(10);

	--------------------CHINH NHANH HIEN TAI DANG KET NOI---------------------------
	IF (@idBranch = (SELECT TOP 1 id From [dbo].[Branch]))
		BEGIN
			IF (@idEmployee = 'CustomerADD')
				BEGIN
					SET @idEmployee = (SELECT TOP 1 id FROM [dbo].[Employee] WHERE role = N'Trưởng phòng');
				END

			SELECT @maxID = COUNT(id) FROM [dbo].[Ticket];
			SET @newID = 'T' + @idBranch +  RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);
			
			INSERT INTO [dbo].[Ticket] VALUES
			(@newID, @totalAmount, @idTrainRide, @idCustomer, @idEmployee, @seatType, NEWID());
		END

----------------------------CHI NHANH HA NOI------------------------------------
	ELSE IF (@idBranch = 'HN')
		BEGIN
			IF (@idEmployee = 'CustomerADD')
				BEGIN
					SET @idEmployee = (SELECT TOP 1 id FROM [LINK_TO_SERVER_KIEN].[QLBVTH_HN].[dbo].[Employee] WHERE role = N'Trưởng phòng');
				END

			SELECT @maxID = COUNT(id) FROM [LINK_TO_SERVER_KIEN].[QLBVTH_HN].[dbo].[Ticket];
			SET @newID = 'T' + @idBranch +  RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);
			
			INSERT INTO [LINK_TO_SERVER_KIEN].[QLBVTH_HN].[dbo].[Ticket] VALUES
			(@newID, @totalAmount, @idTrainRide, @idCustomer, @idEmployee, @seatType, NEWID());
		END
	
---------------------------CHI NHANH HAI PHONG--------------------------------------
	ELSE IF (@idBranch = 'HP')
		BEGIN
			IF (@idEmployee = 'CustomerADD')
				BEGIN
					SET @idEmployee = (SELECT TOP 1 id FROM [LINK_TO_SERVER_THANG].[QLBVTH_HP].[dbo].[Employee] WHERE role = N'Trưởng phòng');
				END

			SELECT @maxID = COUNT(id) FROM [LINK_TO_SERVER_THANG].[QLBVTH_HP].[dbo].[Ticket];
			SET @newID = 'T' + @idBranch +  RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);
			
			INSERT INTO [LINK_TO_SERVER_THANG].[QLBVTH_HP].[dbo].[Ticket] VALUES
			(@newID, @totalAmount, @idTrainRide, @idCustomer, @idEmployee, @seatType, NEWID());
		END

-----------------------------------CHI NHANH DA NANG-------------------------------------
	ELSE IF (@idBranch = 'DN')
		BEGIN
			IF (@idEmployee = 'CustomerADD')
				BEGIN
					SET @idEmployee = (SELECT TOP 1 id FROM [LINK_TO_SERVER_HUNG].[QLBVTH_DN].[dbo].[Employee] WHERE role = N'Trưởng phòng');
				END

			SELECT @maxID = COUNT(id) FROM [LINK_TO_SERVER_HUNG].[QLBVTH_DN].[dbo].[Ticket];
			SET @newID = 'T' + @idBranch +  RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);
			
			INSERT INTO [LINK_TO_SERVER_HUNG].[QLBVTH_DN].[dbo].[Ticket] VALUES
			(@newID, @totalAmount, @idTrainRide, @idCustomer, @idEmployee, @seatType, NEWID());
		END


-----------------------------------CHI NHANH HO CHI MINH------------------------------------------
	ELSE 
		BEGIN
			IF (@idEmployee = 'CustomerADD')
				BEGIN
					SET @idEmployee = (SELECT TOP 1 id FROM [LINK_TO_SERVER_QUAN].[QLBVTH_HCM].[dbo].[Employee] WHERE role = N'Trưởng phòng');
				END

			SELECT @maxID = COUNT(id) FROM [LINK_TO_SERVER_QUAN].[QLBVTH_HCM].[dbo].[Ticket];
			SET @newID = 'T' + @idBranch +  RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3);
			
			INSERT INTO [LINK_TO_SERVER_QUAN].[QLBVTH_HCM].[dbo].[Ticket] VALUES
			(@newID, @totalAmount, @idTrainRide, @idCustomer, @idEmployee, @seatType, NEWID());
		END
END