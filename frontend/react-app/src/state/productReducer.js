const productReducer = (state = {selectedProducts : []}, action) => {
    switch(action.type){
        case "selectedProducted":
            return action.data;
    }
    return state;
};

export default productReducer;