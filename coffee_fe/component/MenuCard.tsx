import {Card, CardActions, CardContent, CardHeader} from "@mui/material";
import Button from "@mui/material/Button";
import {useSelector} from "react-redux";
import {RootState} from "../reducers/store/rootReducer";
import Image from "next/image";
import {CoffeeRs} from "../interfaces/rs/coffeeRs";


const MenuCard = (props:CoffeeRs) => {

    const loginInfo = useSelector((state:RootState) => state.login);
    const axios = require('axios');

    const onClickOrder = () => {

    }

    return(
        <>
            <Card>
                <CardHeader title={props.menuName}/>
                {/*<CardHeader title="메뉴 이름"/>*/}
                <CardContent>
                    <div>{props.category}</div>
                    <Image src={require('../public/coffeeImage.png')} width={100} height={100}/>
                </CardContent>
                <CardActions>
                    {loginInfo.login ?
                        <Button onClick={onClickOrder} variant="contained" color="primary">주문하기</Button>
                        // <Button variant="contained" color="primary">주문하기</Button>
                        : <Button disabled={true} variant="contained" color="primary">주문하기</Button>
                    }
                </CardActions>
            </Card>
        </>
    );
};

export default MenuCard;