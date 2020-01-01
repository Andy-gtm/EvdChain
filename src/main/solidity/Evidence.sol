pragma solidity >=0.4.22 <0.6.0;

import "./Ownable.sol";
import "./SafeMath.sol";

contract Evidence is Ownable{
    using SafeMath for uint;
    string public name;

    function write(string memory _name) public onlyOwner{
        name=_name;
    }
}
