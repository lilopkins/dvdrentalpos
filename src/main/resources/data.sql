-- This data is only loaded in the testing context!

-- Token for Testing, valid for 1 week after database initialisation
INSERT INTO `staff_tokens` VALUES (1, '__testing_token__', '127.0.0.1', DATEADD('YEAR', 1, NOW()));
INSERT INTO `staff_tokens` VALUES (2, '__expired_testing_token__', '127.0.0.1', DATEADD('YEAR', -1, NOW()));

-- Customer login for testing
INSERT INTO `customer_logins` VALUES (1, 'Customer', '8cb2237d0679ca88db6464eac60da96345513964');
