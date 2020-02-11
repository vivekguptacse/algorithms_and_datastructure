package datastructure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implemented LRU Cache by using Hash Map and ArrayList. 
 * 
 * @author Vivek
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V>
{
	private List<K> list;

	private HashMap<K, V> map;

	private int size;

	public LRUCache(int size)
	{
		this.size = size;
		list = new ArrayList<K>(this.size);
		map = new HashMap<>(this.size);
	}

	public void add(K key, V value)
	{
		if (size == list.size())
		{
			System.out.println("Removing as Cache is Full ..  Key  " + list.get(0));

			map.remove(list.get(0));
			list.remove(0);
		}

		if (list.contains(key))
		{
			int indexOf = list.indexOf(key);
			list.remove(indexOf);
			list.add(key);
			map.put(key, value);
			System.out.println("Updating Key  " + key);

		} else
		{
			list.add(key);
			map.put(key, value);
			System.out.println("Adding New Key  " + key);

		}
	}

	public V get(K key)
	{

		if (list.contains(key))
		{
			System.out.println("getting Key  " + key);

			int indexOf = list.indexOf(key);
			list.remove(indexOf);
			list.add(key);
			return map.get(key);
		}

		return null;
	}

	public void remove(K key)
	{
		if (list.contains(key))
		{
			map.remove(key);
			int indexOf = list.indexOf(key);
			list.remove(indexOf);
			System.out.println("removing Key  " + key);
		}
	}

	@Override
	public String toString()
	{
		String str = "[ LRU Cache : " + "Map Value " + map.toString() + "Cache order" + list.toString() + " ]";
		return str;
	}

	public List<K> getList()
	{
		return list;
	}

	public void setList(List<K> list)
	{
		this.list = list;
	}

	public HashMap<K, V> getMap()
	{
		return map;
	}

	public void setMap(HashMap<K, V> map)
	{
		this.map = map;
	}

	public static void main(String[] args)
	{
		LRUCache<Integer, Integer> lrucache = new LRUCache<>(3);
		lrucache.add(1, 1);
		lrucache.add(1, 2);
		lrucache.add(2, 1);
		lrucache.add(3, 1);
		lrucache.add(4, 1);
		lrucache.add(5, 1);
		System.out.println(lrucache);
		lrucache.get(4);
		lrucache.get(3);
		System.out.println(lrucache);

	}

}
