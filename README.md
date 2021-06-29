# GangOf5-gestion-ouvrage
Projet PiDev : Gestion des ouvrages


/*
	 * to manage the autorisation to your crud use token
	 * 
	 *  first   :  add both functions "boolean canCrudUser" in your service 
	 * second   :  use the following blocks to set autorisation only fo admin or manager like code bellow
	 */
	
	/*
	 * public List<Claim> listClaims(String token) throws CustomException, AuthenticationFailException {
			User managerUser = authenticationService.getUser(token);
			if (!canCrudUser(managerUser.getRole())) {
				// user can't create new user
				throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
			}
			
			// .............
			
	 */
	
	
	boolean canCrudUser(Role role) {
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		return false;
	}

	boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
		Role role = userUpdating.getRole();
		// admin and manager can crud any user
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		// user can update his own record, but not his role
		if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
			return true;
		}
		return false;
	}
	
	
