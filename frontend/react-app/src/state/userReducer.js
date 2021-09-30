const userReducer = (state = {isAuth: false}, action) => {
    switch(action.type){
        case "setUserLogin":
            action.data["isAuth"] = true;
            return action.data;
        case "setUserLogout":
            action.data["isAuth"] = false;
            return action.data;
    }
    return state;
};

export default userReducer;